import org.hyperskill.hstest.dynamic.input.DynamicTesting;
import org.hyperskill.hstest.dynamic.input.DynamicTestingMethod;
import org.hyperskill.hstest.exception.outcomes.WrongAnswer;
import org.hyperskill.hstest.mocks.web.response.HttpResponse;
import org.hyperskill.hstest.stage.SpringTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import platform.CodeSharingPlatform;

import static org.hyperskill.hstest.testing.expect.Expectation.expect;
import static org.hyperskill.hstest.testing.expect.json.JsonChecker.isObject;
import static org.hyperskill.hstest.testing.expect.json.JsonChecker.isString;

public class CodeSharingPlatformTest extends SpringTest {
    public CodeSharingPlatformTest() {
        super(CodeSharingPlatform.class);
    }

    final String API_CODE = "/api/code";
    final String WEB_CODE = "/code";

    final String API_CODE_NEW = "/api/code/new";
    final String WEB_CODE_NEW = "/code/new";

    final String[] SNIPPETS = {
        "public static void ...",
        "class Code { ..."
    };

    static void checkStatusCode(HttpResponse resp, int status) {
        if (resp.getStatusCode() != status) {
            throw new WrongAnswer(
                resp.getRequest().getMethod() + " " +
                    resp.getRequest().getLocalUri() +
                    " should respond with status code " + status + ", " +
                    "responded: " + resp.getStatusCode() + "\n\n" +
                    "Response body:\n\n" + resp.getContent()
            );
        }
    }

    static void checkTitle(Document doc, String url, String title) {
        if (!doc.title().equals(title)) {
            throw new WrongAnswer("GET " + url +
                " should contain title \"" + title + "\"");
        }
    }

    static Element checkSingleTag(Document doc, String url, String tag) {
        Elements elems = checkElemsByTag(doc, url, tag, 1);
        return elems.get(0);
    }

    static Elements checkElemsByTag(Document doc, String url, String tag, int length) {
        Elements elems = doc.getElementsByTag(tag);
        if (elems.size() != length) {
            throw new WrongAnswer("GET " + url +
                " should contain " + length + " <" + tag + "> " +
                "element"+ (length == 1 ? "" : "s") +", found: " + elems.size());
        }
        return elems;
    }

    static Element getById(Document doc, String url, String id, String tag) {
        Element elem = doc.getElementById(id);

        if (elem == null) {
            throw new WrongAnswer("GET " + url +
                " should contain an element with id \"" + id + "\", no one found");
        }

        if (!elem.tagName().equals(tag)) {
            throw new WrongAnswer("GET " + url +
                " should contain an element with id  \"" + id + "\" and tag \"" + tag + "\", " +
                "found another tag: \"" + elem.tagName() + "\"");
        }

        return elem;
    }

    @DynamicTestingMethod
    public DynamicTesting[] dt = new DynamicTesting[] {
        this::getApiCode,
        this::checkApiCode,
        this::checkWebCode,
        this::checkWebCodeNew,

        () -> postSnippet(SNIPPETS[0]),
        this::getApiCode,
        this::checkApiCode,
        this::checkWebCode,

        () -> postSnippet(SNIPPETS[1]),
        this::getApiCode,
        this::checkApiCode,
        this::checkWebCode,
    };


    String apiSnippetCode;
    String apiSnippetDate;

    private CheckResult getApiCode() {
        HttpResponse resp = get(API_CODE).send();
        checkStatusCode(resp, 200);

        expect(resp.getContent()).asJson().check(
            isObject()
                .value("code", isString(value -> {
                    if (apiSnippetCode == null) {
                        apiSnippetCode = value;
                        return true;
                    }
                    return apiSnippetCode.equals(value);
                }))
                .value("date", isString(value -> {
                    apiSnippetDate = value;
                    return true;
                }))
        );

        return CheckResult.correct();
    }

    private CheckResult checkApiCode() {
        HttpResponse resp = get(API_CODE).send();
        checkStatusCode(resp, 200);

        expect(resp.getContent()).asJson().check(
            isObject()
                .value("code", isString(value -> apiSnippetCode.equals(value)))
                .value("date", isString(value -> apiSnippetDate.equals(value)))
        );

        return CheckResult.correct();
    }

    private CheckResult checkWebCode() {
        HttpResponse resp = get(WEB_CODE).send();
        checkStatusCode(resp, 200);

        String html = resp.getContent();
        Document doc = Jsoup.parse(html);

        checkTitle(doc, WEB_CODE, "Code");

        Element pre = getById(doc, WEB_CODE, "code_snippet", "pre");
        String webSnippetCode = pre.text();
        if (!webSnippetCode.trim().equals(apiSnippetCode.trim())) {
            return CheckResult.wrong("Web code snippet " +
                "and api code snippet are different");
        }

        Element date = getById(doc, WEB_CODE, "load_date", "span");
        String webSnippetDate = date.text();
        if (!webSnippetDate.trim().equals(apiSnippetDate.trim())) {
            return CheckResult.wrong("Web snippet date " +
                "and api snippet date are different");
        }

        return CheckResult.correct();
    }

    private CheckResult checkWebCodeNew() {
        HttpResponse resp = get(WEB_CODE_NEW).send();
        checkStatusCode(resp, 200);

        String html = resp.getContent();
        Document doc = Jsoup.parse(html);

        checkTitle(doc, WEB_CODE_NEW, "Create");

        getById(doc, WEB_CODE_NEW, "code_snippet", "textarea");
        getById(doc, WEB_CODE_NEW, "send_snippet", "button");

        return CheckResult.correct();
    }

    private CheckResult postSnippet(String snippet) {
        HttpResponse resp = post(API_CODE_NEW, "{\"code\":\"" + snippet + "\"}").send();
        checkStatusCode(resp, 200);

        expect(resp.getContent()).asJson().check(isObject());
        apiSnippetCode = snippet;
        return CheckResult.correct();
    }
}

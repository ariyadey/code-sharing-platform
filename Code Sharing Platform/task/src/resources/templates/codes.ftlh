<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
</head>
<body>
<#list codeList as code>
<#--    <#if date??>-->
    <p><span id="load_date">${code.date}</span></p>
<#--    </#if>-->
<#--    <#if code??>-->
    <pre id="code_snippet">${code.code}</pre>
<#--    </#if>-->
    <br>
</#list>
</body>
</html>
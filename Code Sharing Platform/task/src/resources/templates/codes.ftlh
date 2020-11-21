<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
</head>
<body>
<#list codeList as code>
    <p><span id="load_date">${code.date}</span></p>
    <pre id="code_snippet">${code.code}</pre>
    <br>
</#list>
</body>
</html>
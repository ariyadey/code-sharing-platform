<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
</head>
<body>
<#list codeList as codeList>
    <#if date??>
        <p><span id="load_date">${codeList.date}</span></p>
    </#if>
    <#if code??>
        <pre id="code_snippet">${codeList.code}</pre>
    </#if>
    <br>
</#list>
</body>
</html>
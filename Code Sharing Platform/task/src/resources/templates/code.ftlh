<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
</head>
<body>
<#if date??>
    <span id="load_date">${date}</span>
</#if>
<br>
<#if code??>
    <pre id="code_snippet">${code}</pre>
</#if>
</body>
</html>
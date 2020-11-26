<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
</head>
<body>
<#if code??>
    <p><span id="load_date">${code.dateFormatted}</span></p>
    <pre id="code_snippet">${code.code}</pre>
</#if>
</body>
</html>
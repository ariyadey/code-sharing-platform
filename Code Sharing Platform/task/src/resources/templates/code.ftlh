<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/androidstudio.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<#if code??>
    <p><span id="load_date">${code.date}</span></p>
    <#--Todo: delete "pre" tag-->
    <pre id="code_snippet"><code>${code.code}</code></pre>
    <#--Todo:Add time and views conditionally!-->
</#if>
</body>
</html>
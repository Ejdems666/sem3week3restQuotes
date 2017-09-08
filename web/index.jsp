<html>
<head>
    <title>$Title$</title>
    <title>Person app</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
Quote of the day: <br>
<p id="quote-of-the-day"></p>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Quote</th>
    </tr>
    </thead>
    <tbody id="table-body">
    </tbody>
</table>
<input type="submit" class="button" onclick="fillTableWithQuotes()" value="Refresh">
<form id="add-quote">
    <label for="quote">Quote</label><input id="quote" name="quote" required>
    <input type="submit" class="button" value="Add quote">
</form>
<form id="edit-quote" style="display: none">
    <input name="id" type="hidden">
    <label for="quote1">Phone</label><input id="quote1" name="quote" required>
    <input type="submit" class="button" value="Edit quote">
</form>
<script src="app.js" type="text/javascript"></script>
</body>
</html>

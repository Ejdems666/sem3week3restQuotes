/**
 * Created by adam on 08/09/2017.
 */

loadQuoteOfTheDay();
function loadQuoteOfTheDay() {
    fetch("/api/quote/random")
        .then((resp) => resp.json())
        .then(function (data) {
            document.getElementById("quote-of-the-day").innerHTML = data.quote;
        });
}

fillTableWithQuotes();

function fillTableWithQuotes() {
    fetch("/api/quote")
        .then((resp) => resp.json())
        .then(function (data) {
            var rows = data.map(createRow);
            var table = document.getElementById("table-body");
            table.innerHTML = rows.join("");
        });
}

function createColumnsInARow(data) {
    return '<td>' + data.id + '</td>' +
        '<td>' + data.quote + '</td>' +
        '<td><a onclick="deleteQuote(this.id)" id="' + data.id + '" class="btn">Delete</a></td>' +
        '<td><a class="btn" onclick="initUpdateForm(this)">Edit</a></td>';
}
function createRow(data) {
    return '<tr id="row' + data.id + '">' +
        createColumnsInARow(data) + "</tr>";
}


function deleteQuote(id) {
    fetch("/api/quote/" + id, {
        "method": "DELETE"
    })
        .then(handleErrors)
        .then(function (data) {
            removeRow(id);
            console.log(data.success);
        }).catch(function (error) {
        console.log(error);
    });
}
function handleErrors(response) {
    if (!response.ok) {
        throw Error(response.statusText);
    }
    return response.json();
}
function removeRow(id) {
    var row = document.getElementById("row" + id);
    row.parentNode.removeChild(row);
}

function initUpdateForm(e) {
    var form = document.getElementById("edit-quote");
    form.style.display = "block";
    var formFields = form.getElementsByTagName("input");
    var columnFields = e.parentElement.parentElement.getElementsByTagName("td");
    for (var i = 0; i < 2; i++) {
        formFields[i].value = columnFields[i].innerHTML;
    }
}

document.getElementById("edit-quote").onsubmit = updateQuote;
function updateQuote(e) {
    e.preventDefault();
    var json = serializeForm(e.target);
    fetch("/api/quote/" + json.id, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        "method": "PUT",
        body: JSON.stringify(json)
    })
        .then(handleErrors)
        .then(function (data) {
            var updatedColumns = createColumnsInARow(data);
            document.getElementById("row" + data.id).innerHTML = updatedColumns;
            e.style.display = "none";
        }).catch(function (error) {
        console.log(error);
    });
}

document.getElementById("add-quote").onsubmit = function (e) {
    e.preventDefault();
    var json = serializeForm(e.target);
    fetch("/api/quote", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(json)
    })
        .then(handleErrors)
        .then(function (data) {
            var row = createRow(data)
            document.getElementById("table-body").innerHTML += row;
        }).catch(function (error) {
        console.log(error);
    });
};

function serializeForm(form) {
    var objects = {};
    if (typeof form == 'object' && form.nodeName.toLowerCase() == "form") {
        var fields = form.getElementsByTagName("input");
        for (var i = 0; i < fields.length; i++) {
            objects[fields[i].getAttribute("name")] = fields[i].value;
        }
    }
    return objects;
}

function validateAndRegister() {
    const bdateOK = validateBdate($("#bdate").val());
    const phoneOK = validatePhone($("#phone").val());
    const emailOK = validateEmail($("#email").val());
    if(bdateOK && phoneOK && emailOK) {
        register();
    }
}

function register() {
    const user = {
        firstname : $("#firstname").val(),
        lastname : $("#lastname").val(),
        bdate : $("#bdate").val(),
        phone : $("#phone").val(),
        email : $("#email").val()
    }
    console.log(user);
    $.post("/saveUser", user, function() {
        // nothing here for now
    })
}

function getBooks() {
    $.get("/getBooks", function(books) {
        formatBooks(books);
    })
}

function formatBooks(books) {
    let out = "<table><tr><th>Title</th><th>Author</th><th>Year</th><th>Rating</th></tr>";
    for (const b of books) {
        out += "<tr><td>"+b.title+"</td><td>"+b.author+"</td><td>"+b.year+"</td><td>"+b.rating+"</td></tr>"
    }
    out += "<table>";
    $("#books").html(out); // need to create a div in html for listing books: <div id="books">
}
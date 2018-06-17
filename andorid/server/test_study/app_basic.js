const express = require("express");
const app = express();

app.get('/', function(req, res, next) {
   console.log("get test");
   res.end("get test");
});

var port = 3000;
app.listen(port, function() {
    console.log('connection for Port : ' + port);
});



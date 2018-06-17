

var express = require('express');
var path = require('path');
//var session = require('express-session');
//var MySQLStore = require('express-mysql-session')(session);
var bodyParser  = require("body-parser");

var app = express();

function _start() {
    var self = this;
    self.configureExpress();
}

_start.prototype.configureExpress = function()
{
    var self = this;

    app.use(bodyParser.urlencoded({ extended: true }));
    app.use(bodyParser.json());

    app.use(express.static(path.join(__dirname, './public')));

    //app.use('/data', express.static('data'));
    //app.use('/m/help_avi', express.static('help_avi'));
    //app.use('/m/uploads', express.static('uploads'));

    //var router = express.Router();
    //app.use('/m', router);

    //var routerAct = new RouterRoot(router);
    self.startServer();
}

_start.prototype.startServer = function()
{
    var port = 3000;
    app.listen(port, function() {
        console.log('connection for Port : ' + port);
    });
}

new _start();
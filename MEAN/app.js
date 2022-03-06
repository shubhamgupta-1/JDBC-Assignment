var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var Product = require('./Product.model');

var port = 8000;
var db = 'mongodb://localhost/productapp'

mongoose.connect(db, { useNewUrlParser: true, useUnifiedTopology: true});

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({
  extended: true
}));

app.get('/', function(req, res) {
  res.send('welcome');
});

//cors
app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    next();
  });

app.get('/product', function(req, res) {
    res.header("Access-Control-Allow-Origin", "*");
    Product.find({})
    .exec(function(err, products) {
        if(err) {
            res.send('error occured')
        } else {
            console.log(products);
            res.json(products);
        }
    });
});

app.get('/product/:category', function(req, res) {
    res.header("Access-Control-Allow-Origin", "*");
    Product.findOne({
        category: req.params.category
    })
    .exec(function(err, products) {
        if(err) {
            res.send('error occured')
        } else {
            console.log(products);
            res.json(products);
        }
    });
});

app.listen(port, function() {
  console.log('app listening on port ' + port);
});
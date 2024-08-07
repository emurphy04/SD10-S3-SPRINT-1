const express = require("express");
const app = express();
const PORT = 3000;


app.set('view engine', 'ejs');
app.listen(PORT, () => {
    console.log(`Simple app running on port ${PORT}.`)
});

app.get("/", (request, response) => {
    response.render('index',{ name: 'Easter Bunny', title: 'HOME'})
})
app.get('/about', (request, response) => {
    response.render('about');
});

const mealsRouter = require('./routes/meals.js')
app.use('/meals', mealsRouter);

const shopRouter = require('./routes/shopping.js')
app.use('/shop', shopRouter);

app.use((request, response) => {
    response.status(404).render('fourohfour');
});
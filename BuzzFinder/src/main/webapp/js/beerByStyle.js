console.log("BeerByStyle")
let obj2 = JSON.parse(["[{\"style\":\"\",\"n\":5,\"percent\":0.0021},{\"style\":\"Abbey Single Ale\",\"n\":2,\"percent\":0.0008},{\"style\":\"Altbier\",\"n\":13,\"percent\":0.0054},{\"style\":\"American Adjunct Lager\",\"n\":18,\"percent\":0.0075},{\"style\":\"American Amber / Red Ale\",\"n\":133,\"percent\":0.0552},{\"style\":\"American Amber / Red Lager\",\"n\":29,\"percent\":0.012},{\"style\":\"American Barleywine\",\"n\":3,\"percent\":0.0012},{\"style\":\"American Black Ale\",\"n\":36,\"percent\":0.0149},{\"style\":\"American Blonde Ale\",\"n\":108,\"percent\":0.0448},{\"style\":\"American Brown Ale\",\"n\":70,\"percent\":0.029},{\"style\":\"American Dark Wheat Ale\",\"n\":7,\"percent\":0.0029},{\"style\":\"American Double / Imperial IPA\",\"n\":105,\"percent\":0.0436},{\"style\":\"American Double / Imperial Pilsner\",\"n\":2,\"percent\":0.0008},{\"style\":\"American Double / Imperial Stout\",\"n\":9,\"percent\":0.0037},{\"style\":\"American India Pale Lager\",\"n\":3,\"percent\":0.0012},{\"style\":\"American IPA\",\"n\":424,\"percent\":0.1759},{\"style\":\"American Malt Liquor\",\"n\":1,\"percent\":0.0004},{\"style\":\"American Pale Ale (APA)\",\"n\":245,\"percent\":0.1017},{\"style\":\"American Pale Lager\",\"n\":39,\"percent\":0.0162},{\"style\":\"American Pale Wheat Ale\",\"n\":97,\"percent\":0.0402},{\"style\":\"American Pilsner\",\"n\":25,\"percent\":0.0104},{\"style\":\"American Porter\",\"n\":68,\"percent\":0.0282},{\"style\":\"American Stout\",\"n\":39,\"percent\":0.0162},{\"style\":\"American Strong Ale\",\"n\":14,\"percent\":0.0058},{\"style\":\"American White IPA\",\"n\":11,\"percent\":0.0046},{\"style\":\"American Wild Ale\",\"n\":6,\"percent\":0.0025},{\"style\":\"Baltic Porter\",\"n\":6,\"percent\":0.0025},{\"style\":\"Belgian Dark Ale\",\"n\":11,\"percent\":0.0046},{\"style\":\"Belgian IPA\",\"n\":18,\"percent\":0.0075},{\"style\":\"Belgian Pale Ale\",\"n\":24,\"percent\":0.01},{\"style\":\"Belgian Strong Dark Ale\",\"n\":6,\"percent\":0.0025},{\"style\":\"Belgian Strong Pale Ale\",\"n\":7,\"percent\":0.0029},{\"style\":\"Berliner Weissbier\",\"n\":11,\"percent\":0.0046},{\"style\":\"Bière de Garde\",\"n\":7,\"percent\":0.0029},{\"style\":\"Bock\",\"n\":7,\"percent\":0.0029},{\"style\":\"Braggot\",\"n\":1,\"percent\":0.0004},{\"style\":\"California Common / Steam Beer\",\"n\":6,\"percent\":0.0025},{\"style\":\"Chile Beer\",\"n\":3,\"percent\":0.0012},{\"style\":\"Cider\",\"n\":37,\"percent\":0.0154},{\"style\":\"Cream Ale\",\"n\":29,\"percent\":0.012},{\"style\":\"Czech Pilsener\",\"n\":28,\"percent\":0.0116},{\"style\":\"Doppelbock\",\"n\":7,\"percent\":0.0029},{\"style\":\"Dortmunder / Export Lager\",\"n\":6,\"percent\":0.0025},{\"style\":\"Dubbel\",\"n\":5,\"percent\":0.0021},{\"style\":\"Dunkelweizen\",\"n\":4,\"percent\":0.0017},{\"style\":\"English Barleywine\",\"n\":3,\"percent\":0.0012},{\"style\":\"English Bitter\",\"n\":3,\"percent\":0.0012},{\"style\":\"English Brown Ale\",\"n\":18,\"percent\":0.0075},{\"style\":\"English Dark Mild Ale\",\"n\":6,\"percent\":0.0025},{\"style\":\"English India Pale Ale (IPA)\",\"n\":13,\"percent\":0.0054},{\"style\":\"English Pale Ale\",\"n\":12,\"percent\":0.005},{\"style\":\"English Pale Mild Ale\",\"n\":3,\"percent\":0.0012},{\"style\":\"English Stout\",\"n\":2,\"percent\":0.0008},{\"style\":\"English Strong Ale\",\"n\":4,\"percent\":0.0017},{\"style\":\"Euro Dark Lager\",\"n\":5,\"percent\":0.0021},{\"style\":\"Euro Pale Lager\",\"n\":2,\"percent\":0.0008},{\"style\":\"Extra Special / Strong Bitter (ESB)\",\"n\":20,\"percent\":0.0083},{\"style\":\"Flanders Oud Bruin\",\"n\":1,\"percent\":0.0004},{\"style\":\"Flanders Red Ale\",\"n\":1,\"percent\":0.0004},{\"style\":\"Foreign / Export Stout\",\"n\":6,\"percent\":0.0025},{\"style\":\"Fruit / Vegetable Beer\",\"n\":49,\"percent\":0.0203},{\"style\":\"German Pilsener\",\"n\":36,\"percent\":0.0149},{\"style\":\"Gose\",\"n\":10,\"percent\":0.0041},{\"style\":\"Grisette\",\"n\":1,\"percent\":0.0004},{\"style\":\"Hefeweizen\",\"n\":40,\"percent\":0.0166},{\"style\":\"Herbed / Spiced Beer\",\"n\":9,\"percent\":0.0037},{\"style\":\"Irish Dry Stout\",\"n\":5,\"percent\":0.0021},{\"style\":\"Irish Red Ale\",\"n\":12,\"percent\":0.005},{\"style\":\"Keller Bier / Zwickel Bier\",\"n\":3,\"percent\":0.0012},{\"style\":\"Kölsch\",\"n\":42,\"percent\":0.0174},{\"style\":\"Kristalweizen\",\"n\":1,\"percent\":0.0004},{\"style\":\"Light Lager\",\"n\":12,\"percent\":0.005},{\"style\":\"Low Alcohol Beer\",\"n\":1,\"percent\":0.0004},{\"style\":\"Maibock / Helles Bock\",\"n\":5,\"percent\":0.0021},{\"style\":\"Märzen / Oktoberfest\",\"n\":30,\"percent\":0.0124},{\"style\":\"Mead\",\"n\":5,\"percent\":0.0021},{\"style\":\"Milk / Sweet Stout\",\"n\":10,\"percent\":0.0041},{\"style\":\"Munich Dunkel Lager\",\"n\":4,\"percent\":0.0017},{\"style\":\"Munich Helles Lager\",\"n\":20,\"percent\":0.0083},{\"style\":\"Oatmeal Stout\",\"n\":18,\"percent\":0.0075},{\"style\":\"Old Ale\",\"n\":2,\"percent\":0.0008},{\"style\":\"Other\",\"n\":1,\"percent\":0.0004},{\"style\":\"Pumpkin Ale\",\"n\":23,\"percent\":0.0095},{\"style\":\"Quadrupel (Quad)\",\"n\":4,\"percent\":0.0017},{\"style\":\"Radler\",\"n\":3,\"percent\":0.0012},{\"style\":\"Rauchbier\",\"n\":2,\"percent\":0.0008},{\"style\":\"Roggenbier\",\"n\":2,\"percent\":0.0008},{\"style\":\"Russian Imperial Stout\",\"n\":11,\"percent\":0.0046},{\"style\":\"Rye Beer\",\"n\":18,\"percent\":0.0075},{\"style\":\"Saison / Farmhouse Ale\",\"n\":52,\"percent\":0.0216},{\"style\":\"Schwarzbier\",\"n\":9,\"percent\":0.0037},{\"style\":\"Scotch Ale / Wee Heavy\",\"n\":15,\"percent\":0.0062},{\"style\":\"Scottish Ale\",\"n\":19,\"percent\":0.0079},{\"style\":\"Shandy\",\"n\":3,\"percent\":0.0012},{\"style\":\"Smoked Beer\",\"n\":1,\"percent\":0.0004},{\"style\":\"Tripel\",\"n\":11,\"percent\":0.0046},{\"style\":\"Vienna Lager\",\"n\":20,\"percent\":0.0083},{\"style\":\"Wheat Ale\",\"n\":1,\"percent\":0.0004},{\"style\":\"Winter Warmer\",\"n\":15,\"percent\":0.0062},{\"style\":\"Witbier\",\"n\":51,\"percent\":0.0212}]"]
);
console.log(obj2);



var labels2 = obj2.map(function(e) {
   return e.style;
});
console.log(labels);
var data2 = obj2.map(function(e) {
   return e.n;
});;


console.log(data2);
var ctx2 = document.getElementById('beerByStyles').getContext('2d');

var chart2 = new Chart(ctx2, {
    type: "bar",
    options: {
      indexAxis: 'y',
      legend: {
        display: true,
		fontColor: '#fff',
      }
    },
    data: {
      labels: labels2,
      datasets: [
        {
          label: 'Beer By Style',
          data: data2,
          backgroundColor: '#FFA500',
          borderWidth: 1,
          barThickness: 3,
		  fontColor: '#fff',
        }
      ]
    }
  });

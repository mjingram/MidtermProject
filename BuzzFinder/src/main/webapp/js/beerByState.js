console.log("Hello")
let obj = JSON.parse(["[{\"state\":\" AK\",\"n\":7,\"percent\":0.0125},{\"state\":\" AL\",\"n\":3,\"percent\":0.0054},{\"state\":\" AR\",\"n\":2,\"percent\":0.0036},{\"state\":\" AZ\",\"n\":11,\"percent\":0.0197},{\"state\":\" CA\",\"n\":39,\"percent\":0.0699},{\"state\":\" CO\",\"n\":47,\"percent\":0.0842},{\"state\":\" CT\",\"n\":8,\"percent\":0.0143},{\"state\":\" DC\",\"n\":1,\"percent\":0.0018},{\"state\":\" DE\",\"n\":2,\"percent\":0.0036},{\"state\":\" FL\",\"n\":15,\"percent\":0.0269},{\"state\":\" GA\",\"n\":7,\"percent\":0.0125},{\"state\":\" HI\",\"n\":4,\"percent\":0.0072},{\"state\":\" IA\",\"n\":5,\"percent\":0.009},{\"state\":\" ID\",\"n\":5,\"percent\":0.009},{\"state\":\" IL\",\"n\":18,\"percent\":0.0323},{\"state\":\" IN\",\"n\":22,\"percent\":0.0394},{\"state\":\" KS\",\"n\":3,\"percent\":0.0054},{\"state\":\" KY\",\"n\":4,\"percent\":0.0072},{\"state\":\" LA\",\"n\":5,\"percent\":0.009},{\"state\":\" MA\",\"n\":23,\"percent\":0.0412},{\"state\":\" MD\",\"n\":7,\"percent\":0.0125},{\"state\":\" ME\",\"n\":9,\"percent\":0.0161},{\"state\":\" MI\",\"n\":32,\"percent\":0.0573},{\"state\":\" MN\",\"n\":12,\"percent\":0.0215},{\"state\":\" MO\",\"n\":9,\"percent\":0.0161},{\"state\":\" MS\",\"n\":2,\"percent\":0.0036},{\"state\":\" MT\",\"n\":9,\"percent\":0.0161},{\"state\":\" NC\",\"n\":19,\"percent\":0.0341},{\"state\":\" ND\",\"n\":1,\"percent\":0.0018},{\"state\":\" NE\",\"n\":5,\"percent\":0.009},{\"state\":\" NH\",\"n\":3,\"percent\":0.0054},{\"state\":\" NJ\",\"n\":3,\"percent\":0.0054},{\"state\":\" NM\",\"n\":4,\"percent\":0.0072},{\"state\":\" NV\",\"n\":2,\"percent\":0.0036},{\"state\":\" NY\",\"n\":16,\"percent\":0.0287},{\"state\":\" OH\",\"n\":15,\"percent\":0.0269},{\"state\":\" OK\",\"n\":6,\"percent\":0.0108},{\"state\":\" OR\",\"n\":29,\"percent\":0.052},{\"state\":\" PA\",\"n\":25,\"percent\":0.0448},{\"state\":\" RI\",\"n\":5,\"percent\":0.009},{\"state\":\" SC\",\"n\":4,\"percent\":0.0072},{\"state\":\" SD\",\"n\":1,\"percent\":0.0018},{\"state\":\" TN\",\"n\":3,\"percent\":0.0054},{\"state\":\" TX\",\"n\":28,\"percent\":0.0502},{\"state\":\" UT\",\"n\":4,\"percent\":0.0072},{\"state\":\" VA\",\"n\":16,\"percent\":0.0287},{\"state\":\" VT\",\"n\":10,\"percent\":0.0179},{\"state\":\" WA\",\"n\":23,\"percent\":0.0412},{\"state\":\" WI\",\"n\":20,\"percent\":0.0358},{\"state\":\" WV\",\"n\":1,\"percent\":0.0018},{\"state\":\" WY\",\"n\":4,\"percent\":0.0072}]"]);
console.log(obj);



var labels = obj.map(function(e) {
   return e.state;
});
console.log(labels);
var data = obj.map(function(e) {
   return e.n;
});;


console.log(data);
var ctx = document.getElementById('beerByStateChart').getContext('2d');

var chart = new Chart(ctx, {
    type: "bar",
    options: {
      legend: {
        display: true,
		fontColor: '#fff',
      }
    },
    data: {
      labels: labels,
      datasets: [
        {
          label: 'Breweries By State',
          data: data,
          backgroundColor: '#FFA500',
          borderWidth: 1,
          barThickness: 15,
		  fontColor: '#fff',
        }
      ]
    }
  });

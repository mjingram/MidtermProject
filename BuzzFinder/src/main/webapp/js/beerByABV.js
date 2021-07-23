const ct = document.getElementById('beerByABV').getContext('2d');
let dataSet = JSON.parse(["[{\"abv\":0.001,\"n\":1,\"percent\":0.0004},{\"abv\":0.027,\"n\":2,\"percent\":0.0008},{\"abv\":0.028,\"n\":1,\"percent\":0.0004},{\"abv\":0.032,\"n\":3,\"percent\":0.0012},{\"abv\":0.034,\"n\":1,\"percent\":0.0004},{\"abv\":0.035,\"n\":6,\"percent\":0.0025},{\"abv\":0.037,\"n\":4,\"percent\":0.0017},{\"abv\":0.038,\"n\":6,\"percent\":0.0025},{\"abv\":0.039,\"n\":15,\"percent\":0.0062},{\"abv\":0.04,\"n\":38,\"percent\":0.0158},{\"abv\":0.041,\"n\":9,\"percent\":0.0037},{\"abv\":0.042,\"n\":38,\"percent\":0.0158},{\"abv\":0.043,\"n\":12,\"percent\":0.005},{\"abv\":0.044,\"n\":16,\"percent\":0.0066},{\"abv\":0.045,\"n\":89,\"percent\":0.0369},{\"abv\":0.046,\"n\":32,\"percent\":0.0133},{\"abv\":0.047,\"n\":57,\"percent\":0.0237},{\"abv\":0.048,\"n\":72,\"percent\":0.0299},{\"abv\":0.049,\"n\":59,\"percent\":0.0245},{\"abv\":0.05,\"n\":215,\"percent\":0.0892},{\"abv\":0.051,\"n\":62,\"percent\":0.0257},{\"abv\":0.052,\"n\":107,\"percent\":0.0444},{\"abv\":0.053,\"n\":60,\"percent\":0.0249},{\"abv\":0.054,\"n\":50,\"percent\":0.0207},{\"abv\":0.055,\"n\":158,\"percent\":0.0656},{\"abv\":0.056,\"n\":66,\"percent\":0.0274},{\"abv\":0.057,\"n\":52,\"percent\":0.0216},{\"abv\":0.058,\"n\":66,\"percent\":0.0274},{\"abv\":0.059,\"n\":34,\"percent\":0.0141},{\"abv\":0.06,\"n\":187,\"percent\":0.0776},{\"abv\":0.061,\"n\":21,\"percent\":0.0087},{\"abv\":0.062,\"n\":59,\"percent\":0.0245},{\"abv\":0.063,\"n\":38,\"percent\":0.0158},{\"abv\":0.064,\"n\":21,\"percent\":0.0087},{\"abv\":0.065,\"n\":123,\"percent\":0.051},{\"abv\":0.066,\"n\":20,\"percent\":0.0083},{\"abv\":0.067,\"n\":25,\"percent\":0.0104},{\"abv\":0.068,\"n\":52,\"percent\":0.0216},{\"abv\":0.069,\"n\":32,\"percent\":0.0133},{\"abv\":0.07,\"n\":92,\"percent\":0.0382},{\"abv\":0.071,\"n\":18,\"percent\":0.0075},{\"abv\":0.072,\"n\":37,\"percent\":0.0154},{\"abv\":0.073,\"n\":18,\"percent\":0.0075},{\"abv\":0.074,\"n\":8,\"percent\":0.0033},{\"abv\":0.075,\"n\":43,\"percent\":0.0178},{\"abv\":0.076,\"n\":5,\"percent\":0.0021},{\"abv\":0.077,\"n\":13,\"percent\":0.0054},{\"abv\":0.078,\"n\":10,\"percent\":0.0041},{\"abv\":0.079,\"n\":7,\"percent\":0.0029},{\"abv\":0.08,\"n\":57,\"percent\":0.0237},{\"abv\":0.081,\"n\":4,\"percent\":0.0017},{\"abv\":0.082,\"n\":22,\"percent\":0.0091},{\"abv\":0.083,\"n\":8,\"percent\":0.0033},{\"abv\":0.084,\"n\":3,\"percent\":0.0012},{\"abv\":0.085,\"n\":26,\"percent\":0.0108},{\"abv\":0.086,\"n\":4,\"percent\":0.0017},{\"abv\":0.087,\"n\":10,\"percent\":0.0041},{\"abv\":0.088,\"n\":6,\"percent\":0.0025},{\"abv\":0.089,\"n\":2,\"percent\":0.0008},{\"abv\":0.09,\"n\":24,\"percent\":0.01},{\"abv\":0.091,\"n\":3,\"percent\":0.0012},{\"abv\":0.092,\"n\":13,\"percent\":0.0054},{\"abv\":0.093,\"n\":5,\"percent\":0.0021},{\"abv\":0.094,\"n\":1,\"percent\":0.0004},{\"abv\":0.095,\"n\":9,\"percent\":0.0037},{\"abv\":0.096,\"n\":5,\"percent\":0.0021},{\"abv\":0.097,\"n\":5,\"percent\":0.0021},{\"abv\":0.098,\"n\":3,\"percent\":0.0012},{\"abv\":0.099,\"n\":35,\"percent\":0.0145},{\"abv\":0.1,\"n\":1,\"percent\":0.0004},{\"abv\":0.104,\"n\":1,\"percent\":0.0004},{\"abv\":0.12,\"n\":1,\"percent\":0.0004},{\"abv\":0.125,\"n\":1,\"percent\":0.0004},{\"abv\":0.128,\"n\":1,\"percent\":0.0004}]"]
);

console.log(dataSet);
var labels3 = dataSet.map(function(e) {
   return e.abv;
});
console.log(labels3);
var data3 = dataSet.map(function(e) {
   return e.n;
});;

console.log(data3);
// Chart.defaults.global.defaultFontColor='white';
const chart3 = new Chart(ct, {
  type: 'bar',
  data: {
    labels: labels3,
    datasets: [{
      label: 'ABV of Beer in the Database',
      data: data3,
      backgroundColor: 'orange',
      barThickness: 3,
    }]
  },
  options: {
	indexAxis: 'y',
    scales: {
      xAxes: [{
        display: false,
        barPercentage: 1.3,
        categoryPercentage: 1.3,
        ticks: {
          max: 1
        }
      }, {
        display: true,
        ticks: {
          autoSkip: false,
          max: 1
        }
      }],
      yAxes: [{
        ticks: {
          beginAtZero: true
        }
      }]
    }
  }
});

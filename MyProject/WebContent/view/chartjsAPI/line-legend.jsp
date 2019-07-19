<%@page import="visualChart.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

<%
	JSONObject json = new JSONObject();
	json.setName("sample");
	json.putKey("January","February","March","April","May","June","July", "August", "September", "October", "November", "December");
	Integer[] num1 = {99,34,56,12,14,56,22,11,23,33,12,33};
	String[] num2 = {"99","34","56","12","14","56","22","11","23","33","12","33"};
	Integer[] num3 = {80,24,36,62,74,16,62,31,53,63,72,63};
	Integer[] num4 = {13,24,56,27,27,27,56,71,42,33,33,22};
	Integer[] num5 = {45,45,45,45,45,45,45,45,45,45,45,45};

	json.putValue(num1);
	json.putValue(num3);
	json.putValue(num4);
	json.putValue(num5);

	request.setAttribute("json", json); 
%>

<head>
    <title>Line Chart</title>
    <script src="<%=request.getContextPath() %>/js/Chart.bundle.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <style>
        canvas {
            -moz-user-select: none;
            -webkit-user-select: none;
            -ms-user-select: none;
        }
    </style>
</head>

<body>
    <div style="width:75%;">
        <canvas id="canvas"></canvas>
    </div>
    <br>
    <br>
    <button id="randomizeData">Randomize Data</button>
    <button id="addDataset">Add Dataset</button>
    <button id="removeDataset">Remove Dataset</button>
    <button id="addData">Add Data</button>
    <button id="removeData">Remove Data</button>
    <script>
    	var data = ${json};
        var MONTHS = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        var randomScalingFactor = function() {
            return Math.round(Math.random() * 100 * (Math.random() > 0.5 ? -1 : 1));
        };
        var randomColorFactor = function() {
            return Math.round(Math.random() * 255);
        };
        var randomColor = function(opacity) {
            return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',' + (opacity || '.3') + ')';
        };

        var config = {
            type: 'line',
            data: {
                labels: ["January", "February", "March", "April", "May", "June", "July"],
                datasets: [{
                    label: "My First dataset",
                    data: [	data.sample[0].January,
							data.sample[0].February,
							data.sample[0].March,
							data.sample[0].April,
							data.sample[0].May,
							data.sample[0].June,
							data.sample[0].July ],
                    fill: false,
                    borderDash: [5, 5],
                }, {
                    label: "My Second dataset",
                    data: [ data.sample[1].January,
							data.sample[1].February,
							data.sample[1].March,
							data.sample[1].April,
							data.sample[1].May,
							data.sample[1].June,
							data.sample[1].July ],
                    fill: false,
                    borderDash: [5, 5],
                }, {
                    label: "My Third dataset - No bezier",
                    data: [ data.sample[2].January,
							data.sample[2].February,
							data.sample[2].March,
							data.sample[2].April,
							data.sample[2].May,
							data.sample[2].June,
							data.sample[2].July ],
                    lineTension: 0,
                    fill: false,
                }, {
                    label: "My Fourth dataset",
                    data: [ data.sample[3].January,
							data.sample[3].February,
							data.sample[3].March,
							data.sample[3].April,
							data.sample[3].May,
							data.sample[3].June,
							data.sample[3].July ],
                    fill: false,
                }]
            },
            options: {
                responsive: true,
                legend: {
                    position: 'bottom',
                },
                hover: {
                    mode: 'label'
                },
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Month'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Value'
                        }
                    }]
                },
                title: {
                    display: true,
                    text: 'Chart.js Line Chart - Legend'
                }
            }
        };

        $.each(config.data.datasets, function(i, dataset) {
            var background = randomColor(0.5);
            dataset.borderColor = background;
            dataset.backgroundColor = background;
            dataset.pointBorderColor = background;
            dataset.pointBackgroundColor = background;
            dataset.pointBorderWidth = 1;
        });

        window.onload = function() {
            var ctx = document.getElementById("canvas").getContext("2d");
            window.myLine = new Chart(ctx, config);
        };

        $('#randomizeData').click(function() {
            $.each(config.data.datasets, function(i, dataset) {
                dataset.data = dataset.data.map(function() {
                    return randomScalingFactor();
                });

            });

            window.myLine.update();
        });

        $('#addDataset').click(function() {
            var background = randomColor(0.5);
            var newDataset = {
                label: 'Dataset ' + config.data.datasets.length,
                borderColor: background,
                backgroundColor: background,
                pointBorderColor: background,
                pointBackgroundColor: background,
                pointBorderWidth: 1,
                fill: false,
                data: [],
            };

            for (var index = 0; index < config.data.labels.length; ++index) {
                newDataset.data.push(randomScalingFactor());
            }

            config.data.datasets.push(newDataset);
            window.myLine.update();
        });

        $('#addData').click(function() {
            if (config.data.datasets.length > 0) {
                var month = MONTHS[config.data.labels.length % MONTHS.length];
                config.data.labels.push(month);

                $.each(config.data.datasets, function(i, dataset) {
                    dataset.data.push(randomScalingFactor());
                });

                window.myLine.update();
            }
        });

        $('#removeDataset').click(function() {
            config.data.datasets.splice(0, 1);
            window.myLine.update();
        });

        $('#removeData').click(function() {
            config.data.labels.splice(-1, 1); // remove the label first

            config.data.datasets.forEach(function(dataset, datasetIndex) {
                dataset.data.pop();
            });

            window.myLine.update();
        });
    </script>
</body>

</html>

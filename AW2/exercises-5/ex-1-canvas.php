<?php
    require "./ex-1-files.php";
    // Getting values from file
    $result = readData("test.csv");
?>

<html>
    <head>
        <title>CanvasJS</title>
        <!-- Defer and async make the script not to lag the page loading process -->
        <script src="/canvasjs.min.js" defer async></script>
        <script>
            window.addEventListener("load", () => {
                let chart = new CanvasJS.Chart("chart", {
                    animationEnabled: true,
                    exportEnabled: true,
                    theme: "dark1",
                    title: {
                        text: "Produção de conhecimento no IFSP",
                    },
                    axisX: {
                        reversed: false,
                    },
                    toolTip: {
                        shared: true,
                    },
                    data: [
                        {
                            type: "line",
                            name: "Ano",
                            // JSON_NUMERIC_CHECK Verifica se a string é um número e retorna convertido
                            dataPoints: <?php echo json_encode($result["ano"], JSON_NUMERIC_CHECK) ?>
                        },
                        {
                            type: "line",
                            name: "Produção",
                            // JSON_NUMERIC_CHECK Verifica se a string é um número e retorna convertido
                            dataPoints: <?php echo json_encode($result["producao"], JSON_NUMERIC_CHECK) ?>
                        }
                    ],
                });
                chart.render();
            });
        </script>
    </head>
    <body>
        <h1>Produção de conhecimento no IFSP</h1>
        <h5>Gráfico criado utilizando PHP e JavaScript</h5>
        <div id="chart" style="height: 600px; width: 800px;">
        </div>
    </body>
</html>
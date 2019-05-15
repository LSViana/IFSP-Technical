<?php
    require_once "../../src/jpgraph.php";
    require_once "../../src/jpgraph_line.php";
    require "./ex-1-files.php";
    // Getting values from file
    $result = readData("test.csv");
    // Building the chart
    $graph = new Graph(800, 600, "auto"); // Required call
    $graph->SetScale("textlin"); // Required call
    //
    $graph->img->SetMargin(40, 20, 20, 50);
    $graph->title->Set("Produção de conhecimento no IFSP");
    $graph->SetBox(false);
    $graph->xaxis->SetTickLabels($result["ano"]);
    $graph->xaxis->SetTextTickInterval(10, 0);
    $graph->xaxis->SetLabelAngle(90);
    $productionPlot = new LinePlot($result["producao"]);
    $graph->Add($productionPlot);
    // Showing the chart
    $graph->Stroke();
?>
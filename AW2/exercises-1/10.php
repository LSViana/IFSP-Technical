<?php
    function execute10(array $grades) {
        $highestGradeIndex = 0;
        $lowestGradeIndex = 0;

        $index = 0;
        foreach($grades as $grade) {
            if($grade->grade > $grades[$highestGradeIndex]->grade) {
                $highestGradeIndex = $index;
            }
            else if($grade->grade < $grades[$lowestGradeIndex]->grade) {
                $lowestGradeIndex = $index;
            }
            $index++;
        }

        $highestGrade = $grades[$highestGradeIndex];
        $lowestGrade = $grades[$lowestGradeIndex];

        return [
            "highest" => $highestGrade,
            "lowest" => $lowestGrade,
        ];
    }

    // Test JSON
    /*
    [
        {
            "name": "Lucas Viana",
            "grade": 5.0
        },
        {
            "name": "a",
            "grade": 2.0
        },
        {
            "name": "b",
            "grade": 3.0
        },
        {
            "name": "c",
            "grade": 7.0
        },
        {
            "name": "d",
            "grade": 10.0
        },
        {
            "name": "Matheus",
            "grade": 9.0
        }
    ]
    */
?>
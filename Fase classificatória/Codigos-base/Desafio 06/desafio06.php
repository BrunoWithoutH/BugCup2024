<?php
function calcularFrequencias($array) {
    $frequencias = [];
    foreach ($array as $valor) {
        if (isset($frequencias[$valor])) {
            $frequencias[$valor]++;
        } else {
            $frequencias[$valor] = 1;
        }
    }
    return $frequencias;
}

function encontrarModo($array) {
    $frequencias = calcularFrequencias($array);

    if (count($frequencias) == 0) {
        return "Erro: O array está vazio.";
    }

    $maxFreq = max($frequencias);
    $modos = [];
    foreach ($frequencias as $valor => $freq) {
        if ($freq == $maxFreq) {
            $modos[] = $valor;
        }
    }

    if (empty($modos)) {
        return "Erro: Não há modo definido.";
    }

    sort($modos); // Ordena os modos em ordem crescente
    return $modos;
}

$array = (1,2,3,3,3,4,4,5,5,5,12,12,56,56,56,99,99,99);
$modos = encontrarModo($array);

if (is_array($modos)) {
    echo explode(", ", $modos); // Imprime os modos separados por vírgula
} else {
    echo $modos; // Imprime mensagem de erro
}
?>

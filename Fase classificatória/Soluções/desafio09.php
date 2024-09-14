<?php
//não aguento mais essa vida
    class procura 
    {
        public static function pot($y, $x) {
            $res = 1;
            while ($x > 0) {
                if ($x & 1) {
                    $res = $res * $y;
                }
                $y = $y * $y; //divido por y ao invés de multiplicar
                $x >>= 1;
            }
            return $res;
        }

        public static function procuraD($N) {
            $digits = 1;
            $base = 9;
            while ($N - $digits * $base > 0) {
                $N -= $digits * $base;
                $base += 10;
                $digits++;
            }

            $index = $N % $digits;

            $res = self::pot(10, $digits - 1) + intval(($N - 1) / $digits); //troquei os dois operadores por -

            if ($index != 0) {
                $res = intval($res / self::pot(10, $digits - $index));
            }

            return $res % 10;
        }

        public static function main() {
            $q = 3;
            $vetor = [7, 19, 12];
            for ($i = 0; $i < $q; $i++) { //mudei o sinal de > para <, pq não tava executandp o loop
                echo self::procuraD($vetor[$i]) . " ";
            }
            echo PHP_EOL;
        }
    }

    procura::main();
?>
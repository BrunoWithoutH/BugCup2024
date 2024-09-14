function cF(n) {
  let res = 1;
  for (let i = 1; i <= n; i++) {
    res *= i;
  }
  return res;
}

let n = parseInt(prompt("Digite um número para calcular o fatorial:"));

let fat = cf(n);
console.log("O fatorial de " + n + " é " + fat);

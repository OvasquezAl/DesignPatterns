/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


#define ndiscos 4
#include <stdio.h>
#include <stdlib.h>
#include "cola.cpp"

int discos = ndiscos;
int fin = ndiscos - 1;
int valor;

int proximo(int v, int i) {
  v += i;
  if (v >= 3) {
    v -= 3;
  }
  if (v >= 3) {
    v -= 3;
  }
  if (v >= 3) {
    v -= 3;
  }
  return v;
}

void imprimir(int s[]) {
  for (int i = 0; s[i] < 20; i++) {
    if (i % 12 == 0)
      printf("----------------\n");
    if ((i + 1) % 4 == 0) {
      printf(" <%d> \n", s[i]+1);
    } else {
      (s[i] == 10) ? printf("   ") : printf("[%d]", s[i]);
    }
  }
}

int main() {

  printf("\t\t\t\t CALCULANDO... \n\n\t\t\t\t\n");

  tcola *n = NULL;
  int y[1] = {20};

  int aguja1[discos];
  int agujar[discos];

  for (int i = 0; i < discos; i++) {
    aguja1[i] = discos - i;
  }
  for (int i = 0; i < discos; i++) {
    agujar[i] = 10;
  }

  printf("\n\n\n\n\t\t\t\t CALCULANDO...\n ");

  agregar(&n, aguja1, agujar, agujar, discos - 1, -1, -1, y);

  valor = obtenerc(&n);

  while (valor != fin) {
    int *previos = obteneranteriores(&n);
     //printf("datos previos\n");
    for (int p = 0; p < 3; p++) {
      for (int j = 1; j < 2; j++) {
        int pd = proximo(p, j);
//printf("combinacion\n");
        if (nivel(&n, p) > -1 && p != pd) {
          int matrixtem[3][discos + 1];

          int *to = datostorre(&n, 0);
          for (int i = 0; i < discos; i++) {
            matrixtem[0][i] = to[i];
          }

          matrixtem[0][discos] = nivel(&n, 0);

          to = datostorre(&n, 1);
          for (int i = 0; i < discos; i++) {
            matrixtem[1][i] = to[i];
          }
          matrixtem[1][discos] = nivel(&n, 1);

          to = datostorre(&n, 2);
          for (int i = 0; i < discos; i++) {
            matrixtem[2][i] = to[i];
          }
          matrixtem[2][discos] = nivel(&n, 2);

          //printf("matrix previa cargada\n");
          int vdo;

          if (matrixtem[p][discos] >= 0) {
            vdo = matrixtem[p][matrixtem[p][discos]];
          } else {
            vdo = 10;
          }

          int vdd;

          if (matrixtem[pd][discos] >= 0) {
            vdd = matrixtem[pd][matrixtem[pd][discos]];
          } else {
            vdd = 10;
          }
          //printf("valores de los discos determinados\n");
          if (vdo < vdd && vdo != 10) {
            // //printf("\t\t\t\t\t {%d,%d}\n", p, pd);
            // //printf("--[>%d ",profundidad );
            // sabermovimiento(matrixtem[p][matrixtem[p][discos]], p, pd);

            matrixtem[pd][discos] += 1;

            matrixtem[pd][matrixtem[pd][discos]] =
                matrixtem[p][matrixtem[p][discos]];
            matrixtem[p][matrixtem[p][discos]] = 10;
            matrixtem[p][discos] -= 1;

            // imprimirmatrix(matrixtem);
            //printf("transformacion realizada\n");


          int a1[discos];
          for (int i = 0; i < discos; i++) {
            a1[i] = matrixtem[0][i];
          }
          int a2[discos];
          for (int i = 0; i < discos; i++) {
            a2[i] = matrixtem[1][i];
          }
          int a3[discos];
          for (int i = 0; i < discos; i++) {
            a3[i] = matrixtem[2][i];
          }
          //printf("agregando\n");
          agregar(&n, a1, a2, a3, matrixtem[0][discos], matrixtem[1][discos],
                  matrixtem[2][discos], previos);
          }
        }
      }
    }

    //-----------------------------------------------------------------------------
    eliminar(&n);
    valor = obtenerc(&n);
  }

  int *previos = obteneranteriores(&n);
  imprimir(previos);

  return 0;
}

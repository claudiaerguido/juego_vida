/*
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.practica2.aplicacion;

import java.io.IOException;
import org.practica2.dominio.Tablero;
/**
 * Clase Principal que inicializa las matrices y esablece valores a las variables
 * @author Alejandro Ramirez
 * @version 3.2, 15/03/2021
 */
public class Principal {
	/**
	 * Metodo que procesa la peticion de la sentencia
	 *@param  args entrada que establece el tipo de modo de juego y el numero de estados
	 */
	public static void main(String[] args) throws IOException, InterruptedException{
		int DIMENSION = 60 ;
		int CICLOS = 50;
		int NAVE = 0;
		NAVE = Integer.parseInt(args[0]);
		
		Integer[][] estadoAnterior = new Integer[DIMENSION+2][DIMENSION+2];
		Integer[][] estadoSiguiente = new Integer[DIMENSION+2][DIMENSION+2];

		CICLOS = Integer.parseInt(args[1]);
		
		if(NAVE==0){
			Tablero.generarMatriz(estadoAnterior, estadoSiguiente, DIMENSION, CICLOS);
		}
		if(NAVE==3){
			Tablero.actualizarFichero(estadoAnterior, estadoSiguiente, DIMENSION, CICLOS);

		}if(NAVE==1){
			Tablero.generarNave(estadoAnterior, estadoSiguiente, DIMENSION, NAVE, CICLOS);
		}else{
			Tablero.generarNave(estadoAnterior, estadoSiguiente, DIMENSION, NAVE, CICLOS);
		}
	}
}
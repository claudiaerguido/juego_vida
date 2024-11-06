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
package org.practica2.dominio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * Clase Tablero que genera la matriz y va ejecutando las reglas del juego de la vida.
 * @author Alejandro Ramirez
 * @version 3.2, 15/03/2021
 */
public class Tablero {
	
	static String NOMBRE_FICHERO;
	static int epocas=1;

	/**
	 * Metodo que pasa al array los datos de el txt 
	 *@param  estadoAnterior es el estado Anterior de la matriz 
	 *@param  estadoSiguiente es el estado Siguiente de la matriz
	 *@param  DIMENSION es el tamaño de la matriz
	 *@param  CICLOS es el numero de ciclos que se ejecut el codigo
	 */
	public static void actualizarFichero(Integer[][] estadoAnterior, Integer[][] estadoSiguiente, int DIMENSION, int CICLOS){
		try {
			NOMBRE_FICHERO = "matriz.txt";
				File fichero = new File(NOMBRE_FICHERO);
				Scanner s = new Scanner(fichero);
				
					// Leemos el contenido del fichero
				System.out.println("... Leemos el contenido del fichero ...");

				for (int r=0; r<(DIMENSION+2); r++) {
					for(int i=0; i<(DIMENSION+2) ; i++) {
							estadoAnterior[i][r]= 0;
					}
				}	
					// Leemos linea a linea el fichero
				int i =0;
				while (s.hasNextLine()) {
					String linea = s.nextLine(); 	// Guardamos la linea en un String
					 // print array in rectangular form
						
					 for (int r=0; r<linea.length(); r++) {
						estadoAnterior[i][r]= Character.getNumericValue(linea.charAt(r));
					 }
					 i++;
					System.out.println(linea);
						// Imprimimos la linea
                 }
				generarGraficos(estadoAnterior, estadoSiguiente, DIMENSION, CICLOS);
				s.close();
				
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error, vuelva a ejecutar el código");
		}

				
	}
	
	/**
	 * Metodo que genera las naves 
	 *@param  estadoAnterior es el estado Anterior de la matriz 
	 *@param  estadoSiguiente es el estado Siguiente de la matriz
	 *@param  DIMENSION es el tamaño de la matriz
	 *@param  NAVE establece el tipo de nave que ejecutara el juego
	 *@param  CICLOS es el numero de ciclos que se ejecut el codigo
	 */		
	public static void generarNave(Integer[][] estadoAnterior, Integer[][] estadoSiguiente, int DIMENSION, int NAVE, int CICLOS){
		
		try {
			NOMBRE_FICHERO = "matrizGenerada.txt";
			
			FileWriter fw=new FileWriter(NOMBRE_FICHERO);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int r=0; r<(DIMENSION+2); r++) {
				for(int i=0; i<(DIMENSION+2) ; i++) {
						estadoAnterior[i][r]= 0;
				}
			}

			if(NAVE==1){
				estadoAnterior[15][13]= 1;
				estadoAnterior[15][14]= 1;
				estadoAnterior[15][15]= 1;
				estadoAnterior[14][13]= 1;
				estadoAnterior[14][15]= 1;
				estadoAnterior[13][13]= 1;
				estadoAnterior[13][14]= 1;
				estadoAnterior[13][15]= 1;

			}else if(NAVE==2){
				estadoAnterior[15][12]= 1;
				estadoAnterior[15][13]= 1;
				estadoAnterior[15][14]= 1;
				estadoAnterior[15][15]= 1;
				estadoAnterior[15][16]= 1;
			}else if(NAVE==3){
				estadoAnterior[15][12]= 1;
				estadoAnterior[16][13]= 1;
				estadoAnterior[16][14]= 1;
				estadoAnterior[15][14]= 1;
				estadoAnterior[14][14]= 1;
			}

			for (int r=0; r<(DIMENSION+1); r++) {
				for(int i=0; i<(DIMENSION+1) ; i++) {
					
					bw.write(""+ estadoAnterior[i][r]);
					bw.flush();
				}
				bw.newLine();
			}
			
			generarGraficos(estadoAnterior, estadoSiguiente, DIMENSION, CICLOS);
			bw.close();
		} catch (IOException e) {
			System.out.println("NO SE HA PODIDO GENERAR LA MATRIZ");
			e.printStackTrace();}
	}
	
	/**
	 * Metodo que genera la matriz 
	 *@param  estadoAnterior es el estado Anterior de la matriz 
	 *@param  estadoSiguiente es el estado Siguiente de la matriz
	 *@param  DIMENSION es el tamaño de la matriz
	 *@param  CICLOS es el numero de ciclos que se ejecut el codigo
	 */	
	public static void generarMatriz(Integer[][] estadoAnterior, Integer[][] estadoSiguiente, int DIMENSION, int CICLOS){
		try {
			NOMBRE_FICHERO = "matrizGenerada.txt";
			
			FileWriter fw=new FileWriter(NOMBRE_FICHERO);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int r=0; r<(DIMENSION+2); r++) {
				for(int i=0; i<(DIMENSION+2) ; i++) {
						estadoAnterior[i][r]= 0;
				}
			}
			for (int r=1; r<(DIMENSION+1); r++) {
				for(int i=1; i<(DIMENSION+1) ; i++) {
					
						int generado = (int) (Math.random()*2);
						estadoAnterior[i][r]= generado;
				}
			}
			
			for (int r=0; r<(DIMENSION+2); r++) {
				for(int i=0; i<(DIMENSION+2) ; i++) {
					
					bw.write(""+ estadoAnterior[i][r]);
					bw.flush();
				}
				bw.newLine();
			}
			
			generarGraficos(estadoAnterior, estadoSiguiente, DIMENSION, CICLOS);
			bw.close();
		} catch (IOException e) {
			System.out.println("NO SE HA PODIDO GENERAR LA MATRIZ");
			e.printStackTrace();}
		}

	/**
	 * Metodo que genera los graficos de la matriz para que se vea mejor
	 *@param  estadoAnterior es el estado Anterior de la matriz 
	 *@param  estadoSiguiente es el estado Siguiente de la matriz
	 *@param  DIMENSION es el tamaño de la matriz
	 *@param  CICLOS es el numero de ciclos que se ejecut el codigo
	 */	
	public static void generarGraficos(Integer[][] estadoAnterior, Integer[][] estadoSiguiente, int DIMENSION, int CICLOS){
		NOMBRE_FICHERO = "matrizGenerada.txt";
		if(epocas<CICLOS) {
			try {
				File fichero = new File(NOMBRE_FICHERO);
			Scanner s = new Scanner(fichero);

			FileWriter fw=new FileWriter(NOMBRE_FICHERO);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int r=0; r<(DIMENSION+2); r++) {
				for(int i=0; i<(DIMENSION+2) ; i++) {
					if(estadoAnterior[i][r]==0) {
						bw.write(""+" ");
					}else bw.write(""+"X");
					bw.flush();
				}
				bw.newLine();
			}
				
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	
				System.out.println(linea);
	        }
			epocas++;
			//TIEMPO DELAY0
			TimeUnit.SECONDS.sleep(1);
			leerEstadoActual(estadoAnterior, estadoSiguiente, DIMENSION, CICLOS);
			s.close();
			bw.close();
				
			} catch ( IOException | InterruptedException e) {
				System.out.println("Ha ocurrido un error, vuelva a ejecutar el código");
			}
			
		}
	}
	
	/**
	 * Metodo que lee la matriz y genera el estado siguiente
	 *@param  estadoAnterior es el estado Anterior de la matriz 
	 *@param  estadoSiguiente es el estado Siguiente de la matriz
	 *@param  DIMENSION es el tamaño de la matriz
	 *@param  CICLOS es el numero de ciclos que se ejecut el codigo
	 */
	public static void leerEstadoActual(Integer[][] estadoAnterior, Integer[][] estadoSiguiente, int DIMENSION, int CICLOS){
		
		int cerca=0;
		for (int r=0; r<(DIMENSION+2); r++) {
			for(int i=0; i<(DIMENSION+2) ; i++) {
					estadoSiguiente[i][r]= 0;
			}
		}
		
		for (int r=1; r<(DIMENSION); r++) {
			for(int i=1; i<(DIMENSION) ; i++) {
				
				if(estadoAnterior[r][i]==1) {	
					cerca = 0;
							
							if(estadoAnterior[r+1][i-1]==1) {
								cerca++;
							}
								if(estadoAnterior[r+1][i]==1) {
									cerca++;
								}	
									if(estadoAnterior[r+1][i+1]==1) {
										cerca++;
									}	
										if(estadoAnterior[r][i-1]==1) {
											cerca++;
										}	
											if(estadoAnterior[r][i+1]==1) {
												cerca++;
											}	
												if(estadoAnterior[r-1][i-1]==1) {
													cerca++;
												}	
													if(estadoAnterior[r-1][i]==1) {
														cerca++;
													}	
														if(estadoAnterior[r-1][i+1]==1) {
															cerca++;
															
														}if(cerca==2 || cerca==3) estadoSiguiente[r][i]=1;
															
														else estadoSiguiente[r][i]=0;
														
				}else{
					cerca = 0;
							
							if(estadoAnterior[r+1][i-1]==1) {
								cerca++;
							}
								if(estadoAnterior[r+1][i]==1) {
									cerca++;
								}	
									if(estadoAnterior[r+1][i+1]==1) {
										cerca++;
									}	
										if(estadoAnterior[r][i-1]==1) {
											cerca++;
										}	
											if(estadoAnterior[r][i+1]==1) {
												cerca++;
											}	
												if(estadoAnterior[r-1][i-1]==1) {
													cerca++;
												}	
													if(estadoAnterior[r-1][i]==1) {
														cerca++;
													}	
														if(estadoAnterior[r-1][i+1]==1) {
															cerca++;
															
														}if(cerca==3) estadoSiguiente[r][i]=1;
															
														else estadoSiguiente[r][i]=0;

				}
			}
		}
		cambiarMatrices(estadoAnterior, estadoSiguiente, DIMENSION, CICLOS);
	}
	
	/**
	 * Metodo que cambia una matriz por otra para repetir en bucle todo el proceso
	 *@param  estadoAnterior es el estado Anterior de la matriz 
	 *@param  estadoSiguiente es el estado Siguiente de la matriz
	 *@param  DIMENSION es el tamaño de la matriz
	 *@param  CICLOS es el numero de ciclos que se ejecut el codigo
	 */
	public static void cambiarMatrices(Integer[][] estadoAnterior, Integer[][] estadoSiguiente, int DIMENSION, int CICLOS){
		
		for (int r=0; r<(DIMENSION+2); r++) {
			for(int i=0; i<(DIMENSION+2) ; i++) {
					estadoAnterior[i][r] = estadoSiguiente[i][r];
			}
		}
		generarGraficos(estadoAnterior, estadoSiguiente, DIMENSION, CICLOS);
	}
}

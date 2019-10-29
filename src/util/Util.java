package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Util {
	
	public static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> 
		entriesSortedByValues(Map<K,V> map) {
		SortedSet<Map.Entry<K,V>> sortedEntries = 
			new TreeSet<Map.Entry<K,V>>(
					new Comparator<Map.Entry<K,V>>() {
						@Override 
						public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
							return e1.getValue().compareTo(e2.getValue());
						}
					}
			);
		sortedEntries.addAll(map.entrySet());
		return sortedEntries;
	}
	
	public static String[] getTermos(String texto) {
		return texto.split(" ");
	}

	public static String removeAcento(final String content) {
		
		final char[] utf =  
			"\u00E1\u00C1\u00E3\u00C3\u00E2\u00C2\u00E0\u00C0\u00E4\u00C4\u00E9\u00C9\u00EA\u00CA\u00E8\u00C8\u00EB\u00CB\u00ED\u00CD\u00EF\u00CF\u00EC\u00CC\u00EE\u00CE\u00F3\u00D3\u00F5\u00D5\u00F4\u00D4\u00F2\u00D2\u00F6\u00D6\u00FA\u00DA\u00FB\u00DB\u00F9\u00D9\u00FC\u00DC\u00E7\u00C7\u00FF\u0178\u00FD\u00DD\u00F1\u00D1".toCharArray();
		final char[] ascii = 
			"aAaAaAaAaAeEeEeEeEiIiIiIiIoOoOoOoOoOuUuUuUuUcCyYyYnN".toCharArray();
		final char[] contentArray = content.toCharArray();
		final StringBuffer result = new StringBuffer();
		char currentChar;
		for (int intLIdx = 0; intLIdx < contentArray.length; intLIdx++) {
			currentChar = contentArray[intLIdx];
			for (int intLAcento = 0; intLAcento < utf.length; intLAcento++) {
				if (currentChar == utf[intLAcento]) {
					currentChar = ascii[intLAcento];
					break;
				}
			}
			result.append(currentChar);
		}
		return result.toString().toLowerCase();
	}
	
	public static List<Integer> randomizaIntArray(int valorInicial, int valorFinal) {
		List<Integer> lista = new ArrayList<Integer>();
		for (int i=valorInicial; i<=valorFinal; i++)
			lista.add(i);
		Collections.shuffle(lista);
		return lista;
	}
	
}

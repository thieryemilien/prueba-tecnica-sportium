package com.sportium.events.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.sportium.events.service.SportService;
import com.sportium.events.utils.SportRegex;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SportServiceImpl implements SportService {

	@Override
	public HashMap<String, Object> getInterpretString(String input) {
		log.info("--> Iniciando getInterpretString");
		
		HashMap<String, Object> json = null;

		// Iterar over each sports within enum
		for (SportRegex sport : SportRegex.values()) {
			for (String regex : sport.getRegexList()) {
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(input);

				if (matcher.find()) {
					log.info("--> El evento solicitado es: " + sport);
					json = new HashMap();
					
					switch (sport) {

					case FUTBOL:
						json.put("teamAName", matcher.group(1).trim());

						json.put("teamAScore", matcher.group(2).trim());
						json.put("teamBScore", matcher.group(3).trim());

						json.put("teamBName", matcher.group(4).trim());
						break;
						
					case AMERICA_FOOTBALL:

						json.put("teamAName", matcher.group(1).trim());

						json.put("teamAScore", matcher.group(2).trim());
						json.put("teamBScore", matcher.group(3).trim());

						json.put("teamBName", matcher.group(4).trim());

						json.put("currentPeriod", matcher.group(5).trim());
						break;

					case TENIS:
						// Primera parte de la cadena
						String teamAName = matcher.group(1).trim();
						String scoreboard_teamAScore = matcher.group(2);
						String teamAGames = matcher.group(3);
						String teamAScore = matcher.group(4);

						// Segunda parte de la cadena
						String teamBScore = matcher.group(5).trim();
						String teamBGames = matcher.group(6);
						String scoreboard_teamBScore = matcher.group(7).trim();
						String teamBName = matcher.group(8).trim();
						// Crear objeto JSON para almacenar los resultados

						json.put("teamAName", teamAName);
						json.put("teamBName", teamBName);
						json.put("teamAGames", teamAGames);
						json.put("teamAScore", teamAScore);
						json.put("teamBScore", teamBScore);
						json.put("teamBGames", teamBGames);
						
						json.put("teamBServing", true);

						HashMap<String, String> elements = new HashMap<>();
						elements.put("title", "Sets");
						elements.put("teamAScore", scoreboard_teamAScore);
						elements.put("teamBScore", scoreboard_teamBScore);
						List<HashMap<String, String>> lista = new ArrayList<>();
						lista.add(elements);

						HashMap<String, List<HashMap<String, String>>> scoreboard = new HashMap<>();
						scoreboard.put("elements", lista);

						json.put("scoreboard", scoreboard);

						break;
					}

					break;

				}
			}
			
			if (json != null) break; 
		}
		
		if(json == null) {
			log.info("No hay ningun formato válido para el texto");
			
			json = new HashMap<>();
			json.put("error", "No hay ningun formato válido para el texto");
		}
			
		return json;
	}

}

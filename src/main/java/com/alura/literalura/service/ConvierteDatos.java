// package com.alura.literalura.service;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.JsonMappingException;
// import com.fasterxml.jackson.databind.ObjectMapper;

// public class ConvierteDatos {
// private static ObjectMapper objectMapper = new ObjectMapper();

//     public static <T> T obtenerDatos(String json, Class<T> clase) {
//         try {
//             return objectMapper.readValue(json, clase);
//         } catch (JsonMappingException e) {
//             throw new RuntimeException(e);
//         } catch (JsonProcessingException e) {
//             throw new RuntimeException(e);
//         }
//     }
// }

package com.example.sampleemployeespring.json;

import com.example.sampleemployeespring.beans.Cabin;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("json2/")
public class Json2 {

//    @GetMapping("/1")
//    public void receiveJSON(JSONObject jsonObject){
//        JSONObject jsonObject1= new JSONObject({"name":"Gauri"});
//        Cabin cabin= (Cabin) jsonObject.get("cabin");
//        List<Cabin> cabins = (List<Cabin>) jsonObject.get("cabins");
//        String name= jsonObject.getString("name");
//        String age= jsonObject.getString("age");
//    }
//
//    @PostMapping("/1")
//    public void receiveJSON(JSONObject jsonObject){
//        JSONObject jsonObject1= new JSONObject({"name":"Gauri"});
//        Cabin cabin= (Cabin) jsonObject.get("cabin");
//        List<Cabin> cabins = (List<Cabin>) jsonObject.get("cabins");
//        String name= jsonObject.getString("name");
//        String age= jsonObject.getString("age");
//    }

    //Json to collection
//    List<String> list = new ArrayList<>();
//list.add("one");
//list.add("two");
//
//    Map<String,List<String>> hashMap = new HashMap<>();
//hashMap.put("myList", list);
//
//    ObjectMapper mapper = new ObjectMapper();
//    ObjectNode objectNode = mapper.convertValue(hashMap, ObjectNode.class);
//    Map<String,List<String>> hashMap2 = mapper.convertValue(objectNode, HashMap.class);

}

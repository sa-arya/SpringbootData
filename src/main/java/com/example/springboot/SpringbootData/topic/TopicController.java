package com.example.springboot.SpringbootData.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	TopicServ topicServ;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicServ.getallTopics();
	}
	
	/*@RequestMapping("/topics/{foo}")
	public Topic getTopics(@PathVariable("foo") String id) {
		
		return topicService.getTopic(id);
	}*/
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopics(@PathVariable String id) {
		return topicServ.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicServ.addTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value ="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicServ.updateTopic(id, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicServ.deleteTopic(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value ="/topics/all")
	public void deleteallTopic() {
		topicServ.deleteallTopic();
	}
}


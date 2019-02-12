package com.example.springboot.SpringbootData.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServ {

	@Autowired
	TopicRepo topicRepo;
	
	public List<Topic> getallTopics(){
		List<Topic> topics = new ArrayList<Topic>();
		topicRepo.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		return topicRepo.findById(id);
	}
	
	public void addTopic(Topic topic) {
		topicRepo.save(topic);
	}
	public void updateTopic(String id, Topic topic) {
		topicRepo.save(topic);
	}
	public void deleteTopic(String id) {
		topicRepo.deleteById(id);
		
	}

	public void deleteallTopic() {
		// TODO Auto-generated method stub
		topicRepo.deleteAll();
	}
}

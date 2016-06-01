package com.gifisan.nio.plugin.jms.server;

import java.util.List;

import com.gifisan.nio.component.ReentrantList;

public class P2PConsumerQueue implements ConsumerQueue{
	
	private ReentrantList<Consumer> consumers = new ReentrantList<Consumer>();
	
	public int size(){
		return consumers.size();
	}

	public void offer(Consumer consumer) {
		consumers.add(consumer);
	}

	public void remove(Consumer consumer) {
		consumers.remove(consumer);
	}

	public void remove(List<Consumer> consumers) {
		this.consumers.removeAll(consumers);
	}

	public List<Consumer> getSnapshot() {
		return consumers.getSnapshot();
	}
	
	
	
}
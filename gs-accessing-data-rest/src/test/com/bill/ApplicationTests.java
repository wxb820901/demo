/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bill;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.junit.Before;
import org.junit.Test;

import javax.jms.ConnectionFactory;


public class ApplicationTests {


	//ConnectionFactory connectionFactory;
	BrokerService broker;
	@Before
	public void deleteAllBeforeTests() throws Exception {
		//connectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
		broker = new BrokerService();
		broker.setPersistent(false);
		broker.start();


	}

	@Test
	public void shouldReturnRepositoryIndex() throws Exception {


	}



}

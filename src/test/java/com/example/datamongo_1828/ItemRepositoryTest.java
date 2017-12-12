package com.example.datamongo_1828;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.config.ExecutableProcessConfig;
import de.flapdoodle.embed.process.config.IExecutableProcessConfig;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {
	@Autowired
	public ItemRepository repository;

	@Before
	public void insertData() {
		repository.save(new Item().id(1).tags(Arrays.asList("a", "b")));
		repository.save(new Item().id(2).tags(Arrays.asList("c")).name("Fredrik"));
	}
	
	@Test
	public void findByOptionalTag() {
		List<Item> result = repository.findByOptionalTag("a");
		assertThat(result).extracting("id").containsExactly(1);
	}

	@Test
	public void findByOptionalId() {
		List<Item> result = repository.findByOptionalId(1);
		assertThat(result).extracting("id").containsExactly(1);
	}

	@Test
	public void findByTags() {
		List<Item> result = repository.findByTags("a");
		assertThat(result).extracting("id").containsExactly(1);
	}

	@Test
	public void findByOptionalName() {
		List<Item> result = repository.findByOptionalName("Fredrik");
		assertThat(result).extracting("id").containsExactly(2);
	}
}

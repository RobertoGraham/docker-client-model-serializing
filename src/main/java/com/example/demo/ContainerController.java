package com.example.demo;

import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.spotify.docker.client.DockerClient.ListContainersParam.allContainers;

@RestController
public class ContainerController {

    private final DockerClient dockerClient;

    @Autowired
    public ContainerController(DockerClient dockerClient) {
        this.dockerClient = dockerClient;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Container> containerList() throws DockerException, InterruptedException {
        return dockerClient.listContainers(
                allContainers()
        );
    }
}

/*
 * Copyright (C) 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ro.pippo.core.websocket;

import java.io.IOException;
import java.util.List;

/**
 * Used for accessing the current client connection and all clients connections.
 * It contains helper methods ({@link #sendMessage(String)} and {@link #broadcastMessage(String)},
 * to send a text message to clients.
 *
 * @author Decebal Suiu
 */
public class WebSocketContext {

    private final WebSocketConnection connection;
    private final List<WebSocketConnection> connections;

    public WebSocketContext(List<WebSocketConnection> connections, WebSocketConnection connection) {
        this.connections = connections;
        this.connection = connection;
    }

    public WebSocketConnection getConnection() {
        return connection;
    }

    public List<WebSocketConnection> getConnections() {
        return connections;
    }

    public void sendMessage(String message) throws IOException {
        connection.sendMessage(message);
    }

    public void broadcastMessage(String message) throws IOException {
        for (WebSocketConnection connection : connections) {
            connection.sendMessage(message);
        }
    }

}

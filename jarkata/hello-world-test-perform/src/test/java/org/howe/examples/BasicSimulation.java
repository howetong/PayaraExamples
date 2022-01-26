package org.howe.examples;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.util.Optional;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class BasicSimulation extends Simulation {

    public final String hostname = System.getProperty("url");

    HttpProtocolBuilder httpProtocol = http
            .baseUrl(hostname)
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
            .doNotTrackHeader("1")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0");

    ScenarioBuilder scn = scenario("HelloWorldSimulation")
            .exec(
                    http("Hello World").get("/data/hello")
                    .check(
                            jmesPath("foo")
                                    .transform(extract -> Optional.of(extract).orElse("default"))
                                    .shouldBe("Hello, World")
                    )
            ).pause(100);

    {
        //注入用户，刚开始就一个，协议是http
        setUp(scn.injectOpen(
                atOnceUsers(1),
                rampUsers(100).during(5),
                rampUsersPerSec(10).to(20).during(10)
                ).protocols(httpProtocol)
        ).assertions(
                global().responseTime().mean().lt(2000),
                global().successfulRequests().percent().gt(99.0)
        );
    }
}

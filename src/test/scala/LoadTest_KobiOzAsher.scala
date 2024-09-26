import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class LoadTest_KobiOzAsher extends Simulation {

  val httpProtocol = http
    .baseUrl("https://8e7e-46-117-198-107.ngrok-free.app/KobiSwisaOzYosefAsherFinkelstein") 
    .inferHtmlResources()

  val scn = scenario("Load Test for KobiOzAsher")
    .exec(http("request_1")
    .get("/")
	.check(status.in(200, 429, 503))
	)

  setUp(
    scn.inject(
      rampUsers(100) during (1 minute), 
      constantUsersPerSec(100) during (2 minutes), 
      rampUsers(0) during (1 minute) 
    )
  ).protocols(httpProtocol)
}


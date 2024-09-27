import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class LoadTest_KobiOzAsher extends Simulation {

  val httpProtocol = http
    .baseUrl("https://5a4e-2a00-a041-3d21-8000-112a-1e3c-7967-4363.ngrok-free.app/KobiSwisaOzYosefAsherFinkelstein") 
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

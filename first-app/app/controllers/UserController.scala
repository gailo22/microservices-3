package controllers

import javax.inject.Inject
import javax.inject.Singleton
import play.api.mvc._

@Singleton
class UserController @Inject()(cc: ControllerComponents) 
  extends AbstractController(cc) {

    def addUser() = Action { implicit request =>
      val body = request.body
      body.asFormUrlEncoded match {
          case Some(map) =>
            // persist user info
            Ok(s"The user of name `${map("name").head}` has been created\n") 
          case None => BadRequest("Unknow body format")
      }
    }

}
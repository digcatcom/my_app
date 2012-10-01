package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  val taskForm = Form("label" -> Forms.nonEmptyText)
  
  def index = Action {
    	Redirect(routes.Application.tasks)
  }
  
  def tasks = Action {
  	Ok(views.html.index(models.Task.all(), taskForm))
  }

  def newTask = Action { implicit request =>
  	taskForm.bindFromRequest.fold(
    		errors => BadRequest(views.html.index(models.Task.all(), errors)),
    		label => {
      			models.Task.create(label)
      			Redirect(routes.Application.tasks)
    		}
  	)
  }

  def deleteTask(id: Long) = Action {
  	models.Task.delete(id)
  	Redirect(routes.Application.tasks)
  }

}
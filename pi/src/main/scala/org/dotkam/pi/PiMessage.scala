/**
 * Copyright (C) 2009-2012 Typesafe Inc. <http://www.typesafe.com>
 */
package org.dotkam.pi

import akka.util.Duration

/**
 * TODO: Document Me
 * 
 * @author http://akka.io/docs/akka/2.0/intro/getting-started-first-scala.html
 */

sealed trait PiMessage

case object Calculate extends PiMessage

case class Work( start: Int, nrOfElements: Int ) extends PiMessage

case class Result( value: Double ) extends PiMessage

case class PiApproximation( pi: Double, duration: Duration )
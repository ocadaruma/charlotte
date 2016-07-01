package com.mayreh.charlotte

class Listener(
  val robot: Robot,
  val matcher: Message => Boolean,
  val id: Option[ListenerId] = None,
  val options: Map[String, String],
  val callback: )

package com.mayreh.charlotte

/**
 * Represents a participating user in the chat.
 *
 * @param id A unique ID for the user.
 * @param options An optional Hash of key, value pairs for this user.
 */
case class User(id: UserId, options: Map[String, String] = Map.empty) {
  def apply(key: String): Option[String] = options.get(key)

  val room: Option[Room] = apply("room")
  val name: String = apply("name").getOrElse(id)
}

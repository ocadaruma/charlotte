package com.mayreh.charlotte

/**
 * An adapter is a specific interface to a chat source for robots.
 */
trait Adapter {
  /**
   * A Robot instance.
   */
  def robot: Robot

  /**
   * Raw method for sending data back to the chat source.
   *
   * @param envelope An Object with message, room and user details.
   * @param strings One or more Strings for each message to send.
   */
  def send(envelope: Envelope, strings: String*): Unit

  /**
   * Raw method for sending emote data back to the chat source.
   * Defaults as an alias for send
   *
   * @param envelope An Object with message, room and user details.
   * @param strings One or more Strings for each message to send.
   */
  def emote(envelope: Envelope, strings: String*): Unit = send(envelope, strings: _*)

  /**
   * Raw method for building a reply and sending it back to the chat source.
   *
   * @param envelope An Object with message, room and user details.
   * @param strings One or more Strings for each reply to send.
   */
  def reply(envelope: Envelope, strings: String*): Unit

  /**
   * Raw method for setting a topic on the chat source.
   *
   * @param envelope An Object with message, room and user details.
   * @param strings One or more Strings to set as the topic.
   */
  def topic(envelope: Envelope, strings: String*): Unit

  /**
   * Raw method for playing a sound in the chat source.
   *
   * @param envelope An Object with message, room and user details.
   * @param strings One or more Strings for each play message to send.
   */
  def play(envelope: Envelope, strings: String*): Unit

  /**
   * Raw method for invoking the bot to run.
   */
  def run(): Unit

  /**
   * Raw method for shutting the bot down.
   */
  def close(): Unit

  /**
   * Dispatch a received message to the robot.
   *
   * @param message
   */
  def receive(message: Message): Unit
}

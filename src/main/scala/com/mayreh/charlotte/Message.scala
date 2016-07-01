package com.mayreh.charlotte

import scala.util.matching.Regex
import scala.util.matching.Regex.Match

/**
 * Represents an incoming message from the chat.
 *
 * @param user A user instance that sent the message.
 */
class Message(val user: User, val done: Boolean = false) {
  val room: Option[Room] = user.room

  def finish: Message = new Message(user, done = true)
}

/**
 * Represents an incoming message from the chat.
 *
 * @param user A user instance that sent the message.
 * @param text A String message.
 * @param id A String of the message ID.
 */
class TextMessage(
  user: User,
  text: String,
  id: MessageId) extends Message(user) {

  /**
   * Determines if the message matches the given regex.
   *
   * @param regex A Regex to check.
   * @return a List of Match objects or Nil
   */
  def matches(regex: Regex): List[Match] = regex.findAllMatchIn(text).toList

  /**
   * String representation of a TextMessage
   * @return the message text
   */
  override def toString: String = text
}

/**
 * Represents an incoming user entrance notification.
 *
 * @param user A user instance for the user who entered.
 */
class EnterMessage(user: User) extends Message(user)

/**
 * Represents an incoming user exit notification.
 *
 * @param user A user instance for the user who left.
 */
class LeaveMessage(user: User) extends Message(user)

/**
 * Represents an incoming topic change notification.
 *
 * @param user A user instance for the user who changed the topic.
 * @param text A String of the new topic.
 * @param id A String of the message ID.
 */
class TopicMessage(
  user: User,
  text: String,
  id: MessageId) extends TextMessage(user, text, id)

/**
 * Represents a message that no matchers matched.
 *
 * @param message The original message.
 */
class CatchAllMessage(message: Message) extends Message(message.user)

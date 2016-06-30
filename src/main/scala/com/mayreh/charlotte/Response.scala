package com.mayreh.charlotte

import scala.util.matching.Regex.Match

/**
 * Responses are sent to matching listeners.
 * Messages know about the content and user that made the original message,
 * and how to reply back to them.
 * @param robot A Robot instance.
 * @param message A Message instance.
 * @param matches A Match object from the successful Regex match.
 */
case class Response(robot: Robot, message: Message, matches: Match)

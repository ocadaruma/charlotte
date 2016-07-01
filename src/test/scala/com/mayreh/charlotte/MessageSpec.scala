package com.mayreh.charlotte

import org.scalatest.FunSpec

class MessageSpec extends FunSpec {
  val user = User("1", Map("name" -> "hubottester", "room" -> "#mocha"))

  describe("finish") {
    it("marks the message as done") {
      val testMessage = new Message(user)

      assert(!testMessage.done)
      assert(testMessage.finish.done)
    }
  }

  describe("TextMessage") {
    describe("match") {
      it("should perform standard regex matching") {
        val testMessage = new TextMessage(user, "")

        assert(testMessage.matches("^message123$".r).nonEmpty)
        assert(testMessage.matches("^does-not-match$".r).isEmpty)
      }
    }
  }
}

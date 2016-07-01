package com.mayreh.charlotte

import org.scalatest.FunSpec

class UserSpec extends FunSpec {
  describe("new") {
    it("user id as the default name") {
      val user = User("hubot")

      assert(user.name == "hubot")
    }

    it("sets attributes passed in") {
      val user = User("hubot", Map("foo" -> "1", "bar" -> "2"))

      assert(user("foo").contains("1"))
      assert(user("bar").contains("2"))
    }

    it("uses name attribute when passed in, not id") {
      val user = User("hubot", Map("name" -> "tobuh"))

      assert(user.name == "tobuh")
    }
  }
}

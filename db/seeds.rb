# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)
plans = Plan.create([
  {weeks: 2},
  {weeks: 4},
  {weeks: 6}
])

users = User.create([
  {name: "Daniel", phone: "+528332088924"},
  {name: "Arturo", phone: "+525547318444"}
])

charges = Charge.create(amount: 100, receiver: User.first, payer: User.last, plan: Plan.first)

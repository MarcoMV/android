# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20150411100527) do

  # These are extensions that must be enabled in order to support this database
  enable_extension "plpgsql"

  create_table "charges", force: true do |t|
    t.decimal  "amount"
    t.integer  "payer_id"
    t.integer  "receiver_id"
    t.integer  "plan_id"
    t.string   "verification_code"
    t.boolean  "verified"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  add_index "charges", ["payer_id"], name: "index_charges_on_payer_id", using: :btree
  add_index "charges", ["plan_id"], name: "index_charges_on_plan_id", using: :btree
  add_index "charges", ["receiver_id"], name: "index_charges_on_receiver_id", using: :btree

  create_table "credits", force: true do |t|
    t.decimal  "amount"
    t.string   "compropago_payment_id"
    t.integer  "user_id"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  add_index "credits", ["user_id"], name: "index_credits_on_user_id", using: :btree

  create_table "plans", force: true do |t|
    t.integer  "weeks"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

  create_table "users", force: true do |t|
    t.string   "name"
    t.string   "phone"
    t.string   "login_code"
    t.datetime "created_at"
    t.datetime "updated_at"
  end

end

class User < ActiveRecord::Base
  has_many :charges_as_receiver, foreign_key: 'receiver_id', class_name: 'Charge'
  has_many :charges_as_payer, foreign_key: 'payer_id', class_name: 'Charge'
  has_many :clients, through: :charges_as_receiver, source: :payer
  has_many :receivers, through: :charges_as_payer, source: :receiver
  has_many :credits
end

class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string :name
      t.string :phone
      t.string :login_code
      t.references :roleable
      t.string :roleable_type

      t.timestamps
    end
  end
end
